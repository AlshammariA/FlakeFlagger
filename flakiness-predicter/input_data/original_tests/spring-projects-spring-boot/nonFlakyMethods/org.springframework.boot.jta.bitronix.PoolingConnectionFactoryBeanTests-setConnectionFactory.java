@Test public void setConnectionFactory() throws Exception {
  XAConnectionFactory factory=mock(XAConnectionFactory.class);
  this.bean.setConnectionFactory(factory);
  this.bean.setBeanName("beanName");
  this.bean.afterPropertiesSet();
  this.bean.init();
  this.bean.createPooledConnection(factory,this.bean);
  verify(factory).createXAConnection();
}
