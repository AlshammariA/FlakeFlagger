@Test(expected=NullPointerException.class) public void shouldNotAcceptNullCallback(){
  decorator=new LifecycleCallbackDecorator(null);
}
