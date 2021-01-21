@Test public void should_extract_nested_field(){
  String firstName=fieldSupport.fieldValue("name.first",String.class,yoda);
  assertThat(firstName).isEqualTo("Yoda");
  yoda.name.first=null;
  firstName=fieldSupport.fieldValue("name.first",String.class,yoda);
  assertThat(firstName).isNull();
  yoda.name=null;
  firstName=fieldSupport.fieldValue("name.first",String.class,yoda);
  assertThat(firstName).isNull();
}
