/*
 * Copyright 2015 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.uberfire.ext.layout.editor.client.api;

import com.google.gwt.user.client.ui.IsWidget;
import org.uberfire.ext.layout.editor.client.infra.DndDataJSONConverter;

/**
 * This interface defines the main contract between the Layout Editor's module and components implementations.
 */
public interface LayoutDragComponent {

    public static final String FORMAT = "text";
    static DndDataJSONConverter converter = new DndDataJSONConverter();

    /**
     * The CSS classes used to display the component's icon on the drag palette.
     *
     * @return A CSS class reference
     */
    default String getDragComponentIconClass() {
        return "fa fa-arrows";
    }

    /**
     * The title displayed in the component drag palette.
     */
    String getDragComponentTitle();

    /**
     * Widget shown during the layout edition.
     * <p>
     * Notice this is just a widget preview, so not all the component features need to be available at
     * preview time. Just a widget that gives the user an idea of how the final component might look like.
     * </p>
     * @param ctx The context for the component being rendered
     */
    IsWidget getPreviewWidget(RenderingContext ctx);

    /**
     * The widget that display and provides all the component features.
     * This is the widget during the layout rendering process.
     * @param ctx The context for the component being rendered
     */
    IsWidget getShowWidget(RenderingContext ctx);

    /**
     * A command called before the widget was removed from layout.
     * This is usually used for cleanup tasks.
     * @param ctx The context for the component being rendered
     */
    default void removeCurrentWidget(RenderingContext ctx){
    }

}
