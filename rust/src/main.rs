use std::any::Any;

trait Shape: Any {
    fn as_any(&self) -> &dyn Any;
}

struct Circle {
    radius: f64,
}

struct Rectangle {
    width: f64,
    height: f64,
}

impl Shape for Circle {
    fn as_any(&self) -> &dyn Any {
        self
    }
}
impl Shape for Rectangle {
    fn as_any(&self) -> &dyn Any {
        self
    }
}

fn get_perimeter(s: Box<dyn Shape>) -> f64 {
    match s.as_any() {
        any if any.is::<Rectangle>() => {
            let rectangle = any.downcast_ref::<Rectangle>().unwrap();
            if rectangle.width == rectangle.height {
                println!("Square matched");
                4.0 * rectangle.width
            } else {
                2.0 * (rectangle.width + rectangle.height)
            }
        }
        any if any.is::<Circle>() => {
            let circle = any.downcast_ref::<Circle>().unwrap();
            2.0 * std::f64::consts::PI * circle.radius
        }
        _ => panic!()
    }
}

fn main() {
    println!("{}", get_perimeter(Box::new(Rectangle { width: 2.0, height: 3.0 })));
    println!("{}", get_perimeter(Box::new(Rectangle { width: 3.0, height: 3.0 })));
    println!("{}", get_perimeter(Box::new(Circle { radius: 3.0 })));
}
