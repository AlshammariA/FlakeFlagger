@Test public void assertCreateJobStatisticsAPI(){
  assertThat(JobAPIFactory.createJobStatisticsAPI(getConnectionString(),"namespace",Optional.<String>absent()),instanceOf(JobStatisticsAPI.class));
}
