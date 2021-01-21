@Test public void setDataSource() throws Exception {
  XADataSource dataSource=mock(XADataSource.class);
  XAConnection xaConnection=mock(XAConnection.class);
  Connection connection=mock(Connection.class);
  given(dataSource.getXAConnection()).willReturn(xaConnection);
  given(xaConnection.getConnection()).willReturn(connection);
  this.bean.setDataSource(dataSource);
  this.bean.setBeanName("beanName");
  this.bean.afterPropertiesSet();
  this.bean.init();
  this.bean.createPooledConnection(dataSource,this.bean);
  verify(dataSource).getXAConnection();
}
