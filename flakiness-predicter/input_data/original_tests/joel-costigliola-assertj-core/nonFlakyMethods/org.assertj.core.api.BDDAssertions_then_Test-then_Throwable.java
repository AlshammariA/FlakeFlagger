@Test public void then_Throwable(){
  then(new IllegalArgumentException("Foo")).hasMessage("Foo");
}
