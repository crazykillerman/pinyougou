//引用了我们自定义的brandservice服务和$controller(继承服务)
		app.controller("BrandController",function($scope,$controller,brandservice){
			
			
			/*继承baseController*/
			$controller('baseController',{$scope:$scope});
			//伪继承，这两个参数意义是让两个controller之间的scope联通。通过使scope通用实现的伪继承
			
			
			/* 查询商品列表 */
			$scope.findAll=function(){
				brandservice.findAll().success(function(response){
							$scope.list=response
						});
				}

			
			/* 查询数据方法 */
			$scope.findPage=function(page,size){
				brandService.findPage(page,size).success(
					function(response){
					$scope.list=response.row;
					$scope.paginationConf.totalItems=response.total;
					}
						);
				}
			
			$scope.save=function(){
				var object=null;
				if($scope.entity.id!=null){
					object=brandservice.update($scope.entity);}//调用前面的方法，object代表一个方法
				else{object=brandservice.add($scope.entity);}
				object.success(
					function(response){
						if (response.success){
							$scope.reloadList();//成功则刷新，失败弹出错误框
							}
						else{
							alert(response.message);
						}
					
					}
						);
				}
			
			$scope.findOne=function(id){
				brandservice.findOne(id).success(
						function(response){
							$scope.entity=response;
						});}
			
			
			$scope.dele=function(){
				brandservice.dele($scope.selectIDS).success(
						function(response){
							if (response.success){
								$scope.reloadList();//成功则刷新，失败弹出错误框
								}
							else{
								alert(response.message);
							};})}
			/* 查询方法 */
			$scope.searchEntity={};
			$scope.search=function(page,size){
				brandservice.search(page,size,$scope.searchEntity).success(
						function(response){
						$scope.list=response.row;
						$scope.paginationConf.totalItems=response.total;
						});}
		})