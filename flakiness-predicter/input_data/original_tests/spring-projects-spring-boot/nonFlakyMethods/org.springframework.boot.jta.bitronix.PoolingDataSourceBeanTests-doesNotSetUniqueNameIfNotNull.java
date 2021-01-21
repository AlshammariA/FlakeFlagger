@Test public void doesNotSetUniqueNameIfNotNull() throws Exception {
  this.bean.setBeanName("beanName");
  this.bean.setUniqueName("un");
  this.bean.afterPropertiesSet();
  assertThat(this.bean.getUniqueName(),equalTo("un"));
}
