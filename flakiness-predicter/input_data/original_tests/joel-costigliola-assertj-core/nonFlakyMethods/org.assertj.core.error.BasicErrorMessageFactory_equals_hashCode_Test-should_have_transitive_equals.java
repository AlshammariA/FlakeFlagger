@Test public void should_have_transitive_equals(){
  BasicErrorMessageFactory obj2=new BasicErrorMessageFactory("Hello %s","Yoda");
  BasicErrorMessageFactory obj3=new BasicErrorMessageFactory("Hello %s","Yoda");
  assertEqualsIsTransitive(factory,obj2,obj3);
}
