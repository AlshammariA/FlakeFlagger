@Test(expected=IllegalArgumentException.class) public void shouldNotAcceptInvalidProcessor(){
  new ProcessorDecorator(new Object());
}
