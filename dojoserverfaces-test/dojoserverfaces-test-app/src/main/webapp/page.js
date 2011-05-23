/*******************************************************************************
 * 	Copyright (c) 2011, The Dojo Foundation All Rights Reserved.
 * 	Available via Academic Free License >= 2.1 OR the modified BSD license.
 * 	see: http://dojotoolkit.org/license for details
 *******************************************************************************/
function dojoServerFaces_test_setRowColor(id) {
	if (document.getElementsByTagName) {
		var table = document.getElementById(id);
		var rows = table.rows;
		for ( var i = 0; i < rows.length; i++) {
			var className = rows[i].className;
			if (className == "" || className.indexOf("row") == 0) {
				if ((i & 1) == 0) {
					rows[i].className = "row1";
				} else {
					rows[i].className = "row2";
				}
			}
		}
	}
}