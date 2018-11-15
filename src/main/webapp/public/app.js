var Employee = React.createClass({

  getInitialState: function() {
    return {display: true };
  },
  handleDelete() {
    var self = this;
    $.ajax({
        url: self.props.employee._links.self.href,
        type: 'DELETE',
        success: function(result) {
          self.setState({display: false});
        },
        error: function(xhr, ajaxOptions, thrownError) {
          toastr.error(xhr.responseJSON.message);
        }
    });
  },
  handleEdit() {
      var self = this;
      $.ajax({
          url: self.props.employee._links.self.href,
          type: 'PATCH',
          headers: {'Content-Type': 'application/json'},
          data: {
                      'name' : 'Peje',
                      'age' : '100',
                      'years' : '25'
                    } ,
          success: function(result) {
            self.setState({display: false});
          },
          error: function(xhr, ajaxOptions, thrownError) {
            toastr.error(xhr.responseJSON.message);
          }
      });
    },
  render: function() {

    if (this.state.display==false) return null;
    else return (
      <tr>
          <td>{this.props.employee.name}</td>
          <td>{this.props.employee.password}</td>
          <td>{this.props.employee.id}</td>
          <td>
            <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
          </td>
          <td>
              <button className="btn btn-warning" onClick={this.handleEdit}>Modify</button>
            </td>
      </tr>
    );
  }
});

var EmployeeTable = React.createClass({

  render: function() {

    var rows = [];
    this.props.employees.forEach(function(employee) {
      rows.push(
        <Employee employee={employee} key={employee.name} />);
    });

    return (
      <table className="table table-striped">
          <thead>
              <tr>
                  <th>Name</th>
                  <th>Age</th>
                  <th>Years</th>
                  <th>Delete</th>
                  <th>Edit</th>
              </tr>
          </thead>
          <tbody>{rows}</tbody>
      </table>
    );
  }
});

var App = React.createClass({

  loadEmployeesFromServer: function() {

    var self = this;
    $.ajax({
        url: "http://localhost:8080/employees",
      }).then(function(data) {
      console.log(data);
        self.setState({ employees: data });
      });

  },

  getInitialState: function() {
    return { employees: [] };
  },

  componentDidMount: function() {
    this.loadEmployeesFromServer();
  },

  render() {
    return ( <EmployeeTable employees={this.state.employees} /> );
  }
});

ReactDOM.render(<App />, document.getElementById('root') );
