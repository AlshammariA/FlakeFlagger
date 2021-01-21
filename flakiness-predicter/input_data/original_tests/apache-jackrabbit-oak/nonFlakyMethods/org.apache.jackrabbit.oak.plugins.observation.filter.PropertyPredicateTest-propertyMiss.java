@Test public void propertyMiss(){
  String name="foo";
  final String value="bar";
  PropertyPredicate p=new PropertyPredicate(name,new Predicate<PropertyState>(){
    @Override public boolean apply(    PropertyState property){
      return "baz".equals(property.getValue(STRING));
    }
  }
);
  assertFalse(p.apply(createWithProperty(name,value)));
}
