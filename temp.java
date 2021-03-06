 


 

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class List_2_4_5_WatchFile {

	public static volatile boolean shutDown = false;

	public static void main(String[] args) throws IOException, InterruptedException {

		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					watch();
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th.start();
		System.out.println("注册事件开启");

		Thread.sleep(5000);
		System.out.println("停止事件");
		stop();
	}

	/**
	 * 检测目录内的内容改动 ; 只能是文件夹
	 * 
	 */
	static void watch() throws IOException, InterruptedException {
		
		Path path = Paths.get("/Users/zhidaliao/Documents/workspace/book/src/main/resources/IO/aa");
		WatchService watchService = FileSystems.getDefault().newWatchService();
		WatchKey wk = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

		while (!shutDown) {
			// 阻塞事件  注意协调机制
			wk = watchService.take();
			for (WatchEvent<?> we : wk.pollEvents()) {
				if (we.kind().equals(StandardWatchEventKinds.ENTRY_MODIFY)) {
					System.out.println("文件夹被改动了");
				}
			}
		}

		wk.reset();
	}

	static void stop() {
		shutDown = true;
	}

}




	