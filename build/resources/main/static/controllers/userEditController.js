/*
** Angular Project
**
** Cristiano Quadros
** 
*/
(function(){	
	'use strict';

	angular.module('app')
		.controller("UserEditController", ['$scope', '$location', 'UserService', UserEditController]);
    
	
    function UserEditController ($scope, $location, UserService){
        var self = this;

        $scope.submitForm = saveUser;
        $scope.user = new User();  
        $location.search();

        init();
        
        function User(id, user, role) {
        	this.id = id;
            this.user = user;
            this.role = role;
        }
        
        
        function init(){
        	if ($location.search().id){
        		 $scope.user = new User($location.search().id, $location.search().user, $location.search().role);
        	}
        }
        
        //--Save user
        function saveUser() {
            UserService.persist().save($scope.user, 
                function(data) {
                      console.log('Registro Salvo!');      
                      $location.path('/userlist'); 
                })
        }             
                  
    }     	
})();