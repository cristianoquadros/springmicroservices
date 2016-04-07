angular.module('app')
	.controller('navigation',['$rootScope', '$http', '$location', 
		function($rootScope, $http, $location) {
			var self = this;
			$rootScope.authenticated = false;
			
			var authenticate = function(credentials, callback) {
				var headers = {};
				if (credentials){
					headers = {authorization : "Basic "+ btoa(credentials.username + ":" + credentials.password)};
				}
				$http.get('/demo/user', {headers : headers})
					.success(function(data) {
						if (data.name) {
							$rootScope.authenticated = true;
						} else {
							$rootScope.authenticated = false;
						}
						callback && callback();
					})
					.error(function() {
						$rootScope.authenticated = false;
						callback && callback();
					});
			}

			authenticate();

			self.credentials = {};
			
			self.login = function() {
				authenticate(self.credentials, function() {
					if ($rootScope.authenticated) {
						self.error = false;
					} else {
						self.error = true;
					}
					$location.path("/");
				});
			};
			
			self.logout = function() {
				  $http.post('logout', {})
				  	.success(function() {
				  		$rootScope.authenticated = false;
				  		$location.path("/");
				  	})
				  	.error(function(data) {
				  		$rootScope.authenticated = false;
				  	});
			}					
	}]);