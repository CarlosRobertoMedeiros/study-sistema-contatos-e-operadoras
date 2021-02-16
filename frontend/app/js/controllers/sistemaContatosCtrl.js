angular.module('sistemaContatos',[]).controller('sistemaContatosCtrl', function($scope) {
    $scope.sistema = "Sistema de Gerenciamento de Contatos"
    $scope.contatos = [];    
    $scope.contatos = [
        {id: 1, nome: "Pedro", telefone: "99998888", data: new Date() ,operadora: {nome: "Oi",   codigo: 14, categoria: "Celular"} },
        {id: 2, nome: "Ana",   telefone: "99998877", data: new Date() ,operadora: {nome: "Vivo", codigo: 15, categoria: "Celular"} },
        {id: 3, nome: "Maria", telefone: "99998866", data: new Date() ,operadora: {nome: "Tim",  codigo: 41, categoria: "Celular"} }
    ]
    
    
  });