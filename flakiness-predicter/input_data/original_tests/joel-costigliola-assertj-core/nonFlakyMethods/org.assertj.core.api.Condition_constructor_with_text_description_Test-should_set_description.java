@Test public void should_set_description(){
  String text="your eyes can deceive you; don't trust them";
  Condition<Object> condition=new Condition<Object>(text){
    @Override public boolean matches(    Object value){
      return false;
    }
  }
;
  assertEquals(text,condition.description.value());
}
