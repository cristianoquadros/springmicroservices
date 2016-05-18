/*
** Angular Project
**
** Cristiano Quadros
** 
*/
(function() {
    'use strict';
    
     angular
        .module("app")
        .factory("UserService",  ['$resource', UserService]);       
       
        function UserService ($resource) {
            var urlBase = '/demo/user/';
            
            var service = {
                getUserList : getUserList,
                remove : remove,
                persist : persist
            };
            return service;
            
            
            function getUserList(){
                return $resource(urlBase + "findall",null,
                    {'get': { method: 'GET'}, isArray:true});      
            };
            
            
            function persist(){
                return $resource(urlBase+ "save",{
                     id : '@id', 
                	 user: '@user', 
                	 role: '@role'
                });      
            };  
            
            
            function remove(){
                return $resource(urlBase+ "delete/:id");
            };              
        }    
})();        