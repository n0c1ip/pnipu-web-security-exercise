<div class="navbar navbar-dark bg-dark">
  <a href="/webapp/admin" title="Администрирование" class="btn btn-info">Администрирование</a>
  <span class="navbar-brand">Список пользователей</span>
  <a href="/webapp/logout" title="Выйти" class="btn btn-danger">Выйти</a>
</div>
<div class="panel-body">
  <div class="table-responsive">
    <table class="table table-hover">
	  <thead>
	    <tr>
		  <th>ИМЯ ПОЛЬЗОВАТЕЛЯ</th>
		  <th>ПАРОЛЬ</th>
		  <th>ПОЧТА</th>
		  <th width="100"></th>
		  <th width="100">
		    <button type="button" ng-click="ctrl.addUser()" class="btn btn-info"  data-toggle="modal" data-target="#userEdit">Добавить</button>
		  </th>
		</tr>
	  </thead>
	  <tbody>
	    <tr ng-repeat="c in ctrl.getAllUsers()">
		  <td>{{c.userName}}</td>
		  <td>{{c.password}}</td>
		  <td>{{c.email}}</td>
		  <td><button type="button" ng-click="ctrl.editUser(c.id)" class="btn btn-success custom-width" data-toggle="modal" data-target="#userEdit">Редактировать</button></td>
		  <td><button type="button" ng-click="ctrl.removeUser(c.id)" class="btn btn-danger custom-width">Удалить</button></td>
		</tr>
	  </tbody>
	</table>
  </div>
</div>

<div id="userEdit" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">{{!ctrl.user.id ? 'Добавление' : 'Редактирование'}} пользователя</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <form name="userForm" class="modal-body">
        <div class="form-group">
          <label for="userName">User name:</label>
          <input type="text" ng-model="ctrl.user.userName" class="form-control" id="userName" name="userName" required>
          <span style="color:red" ng-show="userForm.userName.$dirty && userForm.userName.$invalid">
                <span ng-show="userForm.userName.$error.required">Поле "Имя" является обязательным.</span>
          </span>
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="text" ng-model="ctrl.user.password" class="form-control" id="password" name="password" required>
          <span style="color:red" ng-show="userForm.password.$dirty && userForm.password.$invalid">
                <span ng-show="userForm.password.$error.required">Поле "Фамилия" является обязательным.</span>
          </span>
        </div>
          <div class="form-group">
          <label for="email">E-mail: </label>
          <input name="email" type="email" ng-model="ctrl.user.email" class="form-control" id="email" name="email">
          <span style="color:red" ng-show="userForm.email.$invalid">
                <span ng-show="userForm.email.$invalid">Не верный формат e-mail</span>
          </span>
        </div>
      </form>
      <div class="modal-footer">
        <button type="button"
        ng-disabled="userForm.userName.$dirty && userForm.userName.$invalid ||
                     userForm.password.$dirty && userForm.password.$invalid"
        ng-click="ctrl.updateUser()" class="btn btn-primary" data-dismiss="modal">Сохранить</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
      </div>
    </div>
  </div>
</div>