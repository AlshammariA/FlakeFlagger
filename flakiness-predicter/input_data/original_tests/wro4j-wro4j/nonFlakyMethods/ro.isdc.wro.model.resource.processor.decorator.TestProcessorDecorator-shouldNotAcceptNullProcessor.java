@Test(expected=NullPointerException.class) public void shouldNotAcceptNullProcessor(){
  new ProcessorDecorator(null);
}
