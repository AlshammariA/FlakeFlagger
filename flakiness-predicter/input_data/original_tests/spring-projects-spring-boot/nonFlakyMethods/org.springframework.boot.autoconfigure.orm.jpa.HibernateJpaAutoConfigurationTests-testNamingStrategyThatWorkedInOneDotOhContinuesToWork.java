@Test public void testNamingStrategyThatWorkedInOneDotOhContinuesToWork(){
  EnvironmentTestUtils.addEnvironment(this.context,"spring.jpa.hibernate.namingstrategy:" + "org.hibernate.cfg.EJB3NamingStrategy");
  setupTestConfiguration();
  this.context.refresh();
  LocalContainerEntityManagerFactoryBean bean=this.context.getBean(LocalContainerEntityManagerFactoryBean.class);
  String actual=(String)bean.getJpaPropertyMap().get("hibernate.ejb.naming_strategy");
  assertThat(actual,equalTo("org.hibernate.cfg.EJB3NamingStrategy"));
}
