@Test(expected=NullPointerException.class) public void cannotCreateProxyFromNullObjectFactory(){
  ProxyFactory.proxy(null,Object.class);
}
