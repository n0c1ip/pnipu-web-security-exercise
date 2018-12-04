angular.module('webApp').controller('UserController',
    ['UserService', '$scope',  function( UserService, $scope) {

        var self = this;
        self.user = {};
        self.users=[];
        self.today = new Date();

        self.getAllUsers = getAllUsers;
        self.editUser = editUser;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.addUser = addUser;

        function getAllUsers(){
            return UserService.getAllUsers();
        }

        function editUser(id) {
                    UserService.getUser(id).then(
                        function (user) {
                            self.user = user;
                        },
                        function (errResponse) {
                            console.error('Error : ' + errResponse.data);
                        }
                    );
        }

        function updateUser(){
            if (self.user.id) {
                UserService.updateUser(self.user, self.user.id).then(
                        function (response){
                        },
                        function(errResponse){
                        }
                );
            } else {
                UserService.createUser(self.user).then(
                        function (user){
                            self.user = user;
                        },
                        function(errResponse){
                        }
                );
            }
        }

        function removeUser(id){
                    UserService.removeUser(id)
                        .then(
                            function(){
                            },
                            function(errResponse){
                            }
                        );
        }

        function addUser() {
            self.user=UserService.getNewUser();
        }

    }


    ]);