@Test public void should_set_description(){
  Description d=new TextDescription("always in motion is the future");
  Condition<Object> condition=new Condition<Object>(d){
    @Override public boolean matches(    Object value){
      return false;
    }
  }
;
  assertSame(d,condition.description);
}
