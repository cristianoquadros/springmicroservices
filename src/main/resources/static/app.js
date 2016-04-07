angular
		.module('app',['ngRoute'])
		.config(
				function($routeProvider, $httpProvider) {
					$routeProvider
					.when('/', {
						templateUrl : 'views/home.html',
						controller : 'home as controller'
					})
					.otherwise('/');
					
					$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
				}
		)

		.controller('home', function($http) {
			var self = this;
			$http.get('/demo/resource/').success(function(data) {
				self.greeting = data;
			})

		});
