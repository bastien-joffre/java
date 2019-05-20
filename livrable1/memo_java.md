# Mémo Java

## Classe

Une classe est un modèle qui va nous permettre de créer des objets. On va y définir ses futures caractéristiques et les actions que cet objet va pouvoir effectuer.

## Instancier

Une instance est le résultat d’une instanciation. Instantier une classe est le fait de créer un objet (une instance) à partir de sa classe. Une instance est un objet qui va profiter des caractéristiques (attributs et méthodes) propres à sa classe.

## Méthode

En POO, une méthode est une fonction propre à une classe. Il est possible de spécifier la visibilité d’une méthode en utilisant private, public ou static.

## Attributs

Les attributs sont des variables qui se rapportent à une classe. Ils doivent être déclarés dans la définition de la classe. Il est possible de déclarer leur type ainsi que leur visibilité, public ou private.Les attributs publics seront accessibles partout dans le code alors que les attributs privés ne seront utilisables uniquement qu’à partir des objets de leur classe.

## Getter

Un getter est une méthode qui permet d’afficher la valeurs des attributs d’une instance de classe. Par convention, ces méthodes portent le même nom que les attributs qu’elles renvoient.

## Setter

Un setter est une méthode qui permet de modifier la valeur d’une instance de classe. Par convention, elles commencent par le mot «set» suivi du nom de l’attribut qu’elles doivent modifier.

## Surcharger

Surcharger une méthode est le fait de reprendre une méthode d’une classe parent et de lui ajouter des instructions.

## Héritage

L’héritage est le fait de créer une nouvelle classe à partir d’une classe existante. La nouvelle classe est dite «enfant» et descend d’une classe «parent».La classe enfant possède tout les attributs et méthodes de son parent. Les instance de la classe enfant pourront appeler toutes les méthodes de son parent tant que ces méthodes ont été déclarées comme étant publiques.