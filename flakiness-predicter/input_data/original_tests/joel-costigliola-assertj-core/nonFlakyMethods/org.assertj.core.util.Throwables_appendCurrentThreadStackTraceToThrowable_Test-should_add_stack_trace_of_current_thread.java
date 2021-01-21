@Test public void should_add_stack_trace_of_current_thread(){
  final CountDownLatch latch=new CountDownLatch(1);
  new Thread(){
    @Override public void run(){
      RuntimeException e=new RuntimeException("Thrown on purpose");
      exceptionReference.set(e);
      latch.countDown();
    }
  }
.start();
  try {
    latch.await();
  }
 catch (  InterruptedException e) {
    currentThread().interrupt();
  }
  RuntimeException thrown=exceptionReference.get();
  Throwables.appendStackTraceInCurentThreadToThrowable(thrown,"should_add_stack_trace_of_current_thread");
  StackTraceElement[] stackTrace=thrown.getStackTrace();
  assertEquals("org.assertj.core.util.Throwables_appendCurrentThreadStackTraceToThrowable_Test$1.run",asString(stackTrace[0]));
  assertEquals("org.assertj.core.util.Throwables_appendCurrentThreadStackTraceToThrowable_Test.should_add_stack_trace_of_current_thread",asString(stackTrace[1]));
}
