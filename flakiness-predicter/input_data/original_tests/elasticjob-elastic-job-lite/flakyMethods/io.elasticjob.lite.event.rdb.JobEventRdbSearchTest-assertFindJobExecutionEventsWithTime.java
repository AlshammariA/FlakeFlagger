@Test public void assertFindJobExecutionEventsWithTime(){
  Date now=new Date();
  Date tenMinutesBefore=new Date(now.getTime() - 10 * 60 * 1000);
  JobEventRdbSearch.Result<JobExecutionEvent> result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,tenMinutesBefore,null,null));
  assertThat(result.getTotal(),is(500));
  assertThat(result.getRows().size(),is(10));
  result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,now,null,null));
  assertThat(result.getTotal(),is(0));
  assertThat(result.getRows().size(),is(0));
  result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,tenMinutesBefore,null));
  assertThat(result.getTotal(),is(0));
  assertThat(result.getRows().size(),is(0));
  result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,null,now,null));
  assertThat(result.getTotal(),is(500));
  assertThat(result.getRows().size(),is(10));
  result=repository.findJobExecutionEvents(new JobEventRdbSearch.Condition(10,1,null,null,tenMinutesBefore,now,null));
  assertThat(result.getTotal(),is(500));
  assertThat(result.getRows().size(),is(10));
}
