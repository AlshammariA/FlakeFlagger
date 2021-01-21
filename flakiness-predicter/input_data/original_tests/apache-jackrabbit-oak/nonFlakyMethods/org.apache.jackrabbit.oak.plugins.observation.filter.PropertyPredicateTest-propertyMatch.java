@Test public void propertyMatch(){
  String name="foo";
  final String value="bar";
  PropertyPredicate p=new PropertyPredicate(name,new Predicate<PropertyState>(){
    @Override public boolean apply(    PropertyState property){
      return value.equals(property.getValue(STRING));
    }
  }
);
  assertTrue(p.apply(createWithProperty(name,value)));
}
