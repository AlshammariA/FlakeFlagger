@Test(expected=NullPointerException.class) public void shouldNotAcceptNullDecoratedModel(){
  factory=new ModelTransformerFactory(null);
}
