/*
** Angular Project
**
** Cristiano Quadros
** 
*/
(function(){	
	'use strict';

	angular.module('app')
		.controller("UserListController", ['$scope', '$location', 'UserService', UserListController]);
    
	
    function UserListController ($scope, $location, UserService){
        var self = this;
        $scope.removeUser = removeUser;
        $scope.selectUser = selectUser;
        self.userSelected = null;
        
        //Execute
        init();
        
        
        function init() {
        	getUserlist();
        }        
        
        //--[get user list
        function getUserlist(){
        	UserService.getUserList().query(null, 
                function(result) {
                    $scope.items = result;                       
                })        	
        }
        
        //--Select user        
        function selectUser(index) {      
        	 self.userSelected = $scope.items[index];
        }
        
        //--Remove user
        function removeUser() {
            UserService.remove().delete({id:self.userSelected.id},
                function(data) {
                      console.log('Registro Removido!');
                })   
        }         
    }     	
})();