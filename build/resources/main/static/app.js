angular
		.module('app', [])
		.config(
				function($httpProvider) {
					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
				})

		.run(
				function($rootScope, $window) {
					$rootScope.$on('$stateChangeStart', function(event,
							toState, toParams) {
						if (!$rootScope.authenticated) {
							event.preventDefault();
							$window.location.href = "/login.html";
						}
					});
				})

		.controller('home', function($http) {
			var self = this;
			$http.get('/demo/resource/').success(function(data) {
				self.greeting = data;
			})

		});
