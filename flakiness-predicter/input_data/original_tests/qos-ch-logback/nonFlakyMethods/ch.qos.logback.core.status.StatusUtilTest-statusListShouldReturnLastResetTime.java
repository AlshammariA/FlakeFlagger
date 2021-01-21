@Test public void statusListShouldReturnLastResetTime(){
  context.getStatusManager().add(new InfoStatus("test",this));
  long resetTime=System.currentTimeMillis();
  context.getStatusManager().add(new InfoStatus(CoreConstants.RESET_MSG_PREFIX,this));
  context.getStatusManager().add(new InfoStatus("bla",this));
  assertTrue(resetTime <= statusUtil.timeOfLastReset());
}
