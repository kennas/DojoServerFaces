package org.dojoserverfaces.behavior.html.grid;

import org.dojoserverfaces.build.annotation.Behavior;
/**
 *  This behavior will allow for refreshing grid
 *
 */
@Behavior
public class GridRefresh extends SimpleGridOperationBase {

    public GridRefresh() {
        super("render");
    }

}
