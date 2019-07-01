app.controller('baseController',function($scope){
	//分页控件配置
	$scope.paginationConf = {
			 currentPage: 1,/* 当前页面 */
			 totalItems: 8,/* 总数据条数 */
			 itemsPerPage: 8,
			 perPageOptions: [10, 20, 30, 40, 50],
			 onChange: function(){
				 $scope.reloadList();/* 有改变则刷新页面 */
			 }
	}; 
	/* 刷新页面方法 */
	$scope.reloadList=function(){
		$scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
		}
	/*复选框勾选与未勾选更新*/
	$scope.selectIDS=[];//用户勾选的ID集合
	$scope.updateSelection=function($event,id){//$event表示源，$event.target表示那个input复选框本身
		if($event.target.checked){
			$scope.selectIDS.push(id);//push()向集合添加元素
		}
		else{//pop()是不行的，只能pop出最后一个元素
			var index=$scope.selectIDS.indexOf(id);//查找该值的位置
			$scope.selectIDS.splice(index,1);//移除的位置，和移除的个数
		}} 
	
})