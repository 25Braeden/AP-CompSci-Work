mod highway;
use highway::Highway;
use std::io;

fn main() {
    let mut h = Highway::new(5, 20);
    for i in 0..5 {
        h.hwy[i][i] = 1;
        h.hwy[i][i + 6] = 1;
    }

    println!("Before movement:\n{}", h);

    for _ in 0..5 {
        h.move_all_forward();
    }

    println!("After move_all_forward:\n{}", h);

    for _ in 0..5 {
        h.move_all_sideways();
    }

    println!("After move_all_sideways:\n{}", h);

    for _ in 0..5 {
        h.move_all_forward_2();
    }

    println!("After move_all_forward_2:\n{}", h);

    println!("Press Enter to exit...");
    let _ = io::stdin().read_line(&mut String::new());
}
