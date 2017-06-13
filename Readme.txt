FragmentTransaction 各函数调用和fragment生命周期关系
控制fragment切换时的

1.add  remove

06-13 12:01:43.406 1986-1986/? I/Fragment3: onAttach
06-13 12:01:43.406 1986-1986/? I/Fragment3: onCreate
06-13 12:01:43.406 1986-1986/? I/Fragment3: onCreateView
06-13 12:01:43.406 1986-1986/? I/Fragment3: onActivityCreated
06-13 12:01:43.406 1986-1986/? I/Fragment3: onStart
06-13 12:01:43.406 1986-1986/? I/Fragment3: onResume

06-13 12:07:54.046 8765-8765/com.example.sven.fragementdemo I/Fragment3: onPause
06-13 12:07:54.046 8765-8765/com.example.sven.fragementdemo I/Fragment3: onStop
06-13 12:07:54.046 8765-8765/com.example.sven.fragementdemo I/Fragment3: onDestroyView
06-13 12:07:54.046 8765-8765/com.example.sven.fragementdemo I/Fragment3: onDestroy
06-13 12:07:54.046 8765-8765/com.example.sven.fragementdemo I/Fragment3: onDetach

2.attach  detach

06-13 11:57:46.376 29992-29992/com.example.sven.fragementdemo I/Fragment3: onCreateView
06-13 11:57:46.376 29992-29992/com.example.sven.fragementdemo I/Fragment3: onActivityCreated
06-13 11:57:46.376 29992-29992/com.example.sven.fragementdemo I/Fragment3: onStart
06-13 11:57:46.376 29992-29992/com.example.sven.fragementdemo I/Fragment3: onResume

06-13 11:58:13.486 29992-29992/com.example.sven.fragementdemo I/Fragment3: onPause
06-13 11:58:13.486 29992-29992/com.example.sven.fragementdemo I/Fragment3: onStop
06-13 11:58:13.486 29992-29992/com.example.sven.fragementdemo I/Fragment3: onDestroyView


3.hide show
  不会调用到生命周期

4.remove detach replace 都不会保存前一个视图界面

5.只有hide可以

//每次操作都必须开一次事务，commit一次
FragmentManager mFragmentManager = getFragmentManager();
FragmentTransaction mFt = mFragmentManager.beginTransaction();
...
mFt.commit();


FragmentTransaction.addToBackStack(String)
控制按back键的返回层级

主activity中可以区分不同的按钮