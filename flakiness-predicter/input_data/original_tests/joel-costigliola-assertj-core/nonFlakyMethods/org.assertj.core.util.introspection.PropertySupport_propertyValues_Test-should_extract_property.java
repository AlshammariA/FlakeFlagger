@Test public void should_extract_property(){
  Integer age=PropertySupport.instance().propertyValue("age",Integer.class,yoda);
  assertThat(age).isEqualTo(800);
}
