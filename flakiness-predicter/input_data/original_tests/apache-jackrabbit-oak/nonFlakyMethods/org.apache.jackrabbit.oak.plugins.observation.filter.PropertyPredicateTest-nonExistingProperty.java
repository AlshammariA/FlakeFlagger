@Test public void nonExistingProperty(){
  String name="foo";
  final String value="bar";
  PropertyPredicate p=new PropertyPredicate("any",new Predicate<PropertyState>(){
    @Override public boolean apply(    PropertyState property){
      return value.equals(property.getValue(STRING));
    }
  }
);
  assertFalse(p.apply(createWithProperty(name,value)));
}
