@Test public void assertCreateServerStatisticsAPI(){
  assertThat(JobAPIFactory.createServerStatisticsAPI(getConnectionString(),"namespace",Optional.<String>absent()),instanceOf(ServerStatisticsAPI.class));
}
