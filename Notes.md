

- We strongly advise that you always use ListenableFuture instead of Future in all of your code

- A ListenableFuture allows you to register callbacks to be executed once the computation is complete, or if the computation is already complete, immediately.

- Guava provides the ListeningExecutorService interface, which returns a ListenableFuture wherever ExecutorService would return a normal Future. To convert an
  ExecutorService to a ListeningExecutorService, just use MoreExecutors.listeningDecorator(ExecutorService).

- The most important reason to use ListenableFuture is that it becomes possible to have complex chains of asynchronous operations.


