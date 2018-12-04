<!DOCTYPE html>

<html lang="en" ng-app="webApp">
    <head>
        <title>${title}</title>
        <link href="css/app.css" rel="stylesheet"/>
        <link href="css/bootstrap.css" rel="stylesheet"/>
    </head>
    <body>
        <div ui-view></div>
        <script src="js/lib/jquery-3.2.1.slim.min.js"></script>
        <script src="js/lib/popper.min.js"></script>
        <script src="js/lib/bootstrap.min.js" ></script>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-datetime.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/UserService.js"></script>
        <script src="js/app/UserController.js"></script>
    </body>
</html>
