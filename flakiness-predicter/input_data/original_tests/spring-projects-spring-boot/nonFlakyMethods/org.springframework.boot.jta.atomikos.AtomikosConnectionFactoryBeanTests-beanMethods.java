@Test public void beanMethods() throws Exception {
  MockAtomikosConnectionFactoryBean bean=spy(new MockAtomikosConnectionFactoryBean());
  bean.setBeanName("bean");
  bean.afterPropertiesSet();
  assertThat(bean.getUniqueResourceName(),equalTo("bean"));
  verify(bean).init();
  verify(bean,never()).close();
  bean.destroy();
  verify(bean).close();
}
