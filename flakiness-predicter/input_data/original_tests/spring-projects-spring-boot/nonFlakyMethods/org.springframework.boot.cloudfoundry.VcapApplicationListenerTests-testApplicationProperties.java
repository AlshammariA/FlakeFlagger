@Test public void testApplicationProperties(){
  EnvironmentTestUtils.addEnvironment(this.context,"VCAP_APPLICATION:{\"application_users\":[],\"instance_id\":\"bb7935245adf3e650dfb7c58a06e9ece\",\"instance_index\":0,\"version\":\"3464e092-1c13-462e-a47c-807c30318a50\",\"name\":\"foo\",\"uris\":[\"foo.cfapps.io\"],\"started_at\":\"2013-05-29 02:37:59 +0000\",\"started_at_timestamp\":1369795079,\"host\":\"0.0.0.0\",\"port\":61034,\"limits\":{\"mem\":128,\"disk\":1024,\"fds\":16384},\"version\":\"3464e092-1c13-462e-a47c-807c30318a50\",\"name\":\"dsyerenv\",\"uris\":[\"dsyerenv.cfapps.io\"],\"users\":[],\"start\":\"2013-05-29 02:37:59 +0000\",\"state_timestamp\":1369795079}");
  this.initializer.onApplicationEvent(this.event);
  assertEquals("bb7935245adf3e650dfb7c58a06e9ece",this.context.getEnvironment().getProperty("vcap.application.instance_id"));
}
