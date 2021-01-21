@Test public void should_extract_nested_property(){
  String firstName=PropertySupport.instance().propertyValueOf("name.first",String.class,yoda);
  assertThat(firstName).isEqualTo("Yoda");
  yoda.name.first=null;
  firstName=PropertySupport.instance().propertyValueOf("name.first",String.class,yoda);
  assertThat(firstName).isNull();
  yoda.name=null;
  firstName=PropertySupport.instance().propertyValueOf("name.first",String.class,yoda);
  assertThat(firstName).isNull();
}
