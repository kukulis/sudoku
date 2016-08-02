/**
 * 
 */

var fillOneBoard=function(boardData) {
	console.log("fillOneBoard called" );
	for ( var x=0; x<9; x++ )
		for ( var y=0; y<9; y++ )
			$("#cell"+x+y ).val( boardData.values[y*9+x] );
}

var loadBoard = function(root, boardId) {
	console.log("loadBoard called" );
	$("#cell00").val("1");
	// TODO load from ajax and set all values
	$.ajax({
		type : "GET",
//		contentType : "application/json",
		url : root+"rest/get",
		// data : JSON.stringify(search),
		data:{id:boardId},
		// dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			//display(data);
			//enableSearchButton(true);
			fillOneBoard ( data );
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
			//enableSearchButton(true);
		},
		done : function(e) {
			console.log("DONE");
			//enableSearchButton(true);
		}
	});
}

var solveBoard=function(root, boardId) {
	console.log("solveBoard called, root="+root+"  boardId="+boardId );
	
	$.ajax({
		type : "GET",
//		contentType : "application/json",
		url : root+"rest/solve",
		// data : JSON.stringify(search),
		data:{id:boardId},
		// dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			//display(data);
			//enableSearchButton(true);
			fillOneBoard ( data );
			showMessage ( "I tried my best ..." );
		},
		error : function(e) {
			console.log("ERROR: ", e);
			//display(e);
			//enableSearchButton(true);
		},
		done : function(e) {
			console.log("DONE");
			//enableSearchButton(true);
		}
	});
}

var saveChanges = function (root, id) {
	console.log("saveChanges called, root="+root+"  id="+id );
	var values=[];
	for ( var x=0; x<9; x++ )
		for ( var y=0; y<9; y++ )
			values[y*9+x]=parseInt($("#cell"+x+y ).val());
	
	console.log("collected values", values );
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : root+"rest/update?id="+id,
		// data : JSON.stringify(search),
		data:JSON.stringify(values),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			showMessage ( "successfully saved" );
		},
		error : function(e) {
			console.log("ERROR: ", e);
			showMessage ( "failed to save ..." );
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

var showMessage = function ( msg ) {
	$("#message").html(document.createTextNode(msg));
	$("#clearButton").show();
}

var clearMessage = function () {
	$("#message").html(document.createTextNode(""));
	$("#clearButton").hide();
}