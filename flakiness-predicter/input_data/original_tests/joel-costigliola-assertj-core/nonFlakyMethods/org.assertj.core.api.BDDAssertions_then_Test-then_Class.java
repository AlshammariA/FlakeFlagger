@Test public void then_Class(){
  then("Foo".getClass()).isEqualTo(String.class);
}
