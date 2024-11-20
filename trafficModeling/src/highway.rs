use rand::Rng;
use std::fmt;

pub struct Highway {
    pub(crate) hwy: Vec<Vec<i32>>,
}

impl Highway {
    pub fn new(lanes: usize, length: usize) -> Self {
        Highway {
            hwy: vec![vec![0; length]; lanes],
        }
    }

    pub fn add_car(&mut self, lane: usize, x: usize) {
        self.hwy[lane][x] = 1;
    }

    pub fn can_switch_lanes(&self, lane: usize, dir: i32, x: usize) -> bool {
        let target_lane = match (lane as i32 + dir) {
            temp if temp >= 0 && temp < self.hwy.len() as i32 => temp as usize,
            _ => return false,
        };
        self.hwy[target_lane][x] == 0
    }

    pub fn move_all_forward(&mut self) {
        for lane in &mut self.hwy {
            let last_car = lane.pop().unwrap_or(0);
            lane.insert(0, last_car);
        }
    }

    pub fn move_all_sideways(&mut self) {
        let mut rng = rand::thread_rng();

        let mut switch_decisions = vec![];

        for lane_index in 0..self.hwy.len() {
            for i in 0..self.hwy[lane_index].len() {
                if self.hwy[lane_index][i] == 1 {
                    let chance: f32 = rng.gen();

                    if chance < 0.1 && lane_index > 0 && self.hwy[lane_index - 1][i] == 0 {
                        switch_decisions.push((lane_index, i, -1));
                    }
                    else if chance > 0.9 && lane_index < self.hwy.len() - 1 && self.hwy[lane_index + 1][i] == 0 {
                        switch_decisions.push((lane_index, i, 1));
                    }
                }
            }
        }

        for (lane_index, i, dir) in switch_decisions {
            if dir == -1 {
                self.hwy[lane_index - 1][i] = 1;
            } else if dir == 1 {
                self.hwy[lane_index + 1][i] = 1;
            }
            self.hwy[lane_index][i] = 0;
        }
    }



    pub fn move_all_forward_2(&mut self) {
        let mut iterations = self.hwy.len();
        for _ in 0..iterations {
            for lane in &mut self.hwy {
                let lane_length = lane.len();
                let car_positions: Vec<usize> = lane.iter().enumerate().filter(|(_, &v)| v == 1).map(|(i, _)| i).collect();

                // Loop through pairs of cars and move them halfway toward each other
                for i in 0..car_positions.len() {
                    // Get the current car position
                    let current_car_pos = car_positions[i];

                    // Check if the car is adjacent to the next car
                    let next_car_pos = if i == car_positions.len() - 1 {
                        car_positions[0] // Loop to the first car
                    } else {
                        car_positions[i + 1] // The next car in the list
                    };

                    // Skip moving the car if it's adjacent to the next car
                    if (next_car_pos == current_car_pos + 1) || (next_car_pos == 0 && current_car_pos == lane_length - 1) {
                        continue;
                    }

                    // Calculate the distance between the cars
                    let distance = if next_car_pos >= current_car_pos {
                        next_car_pos - current_car_pos
                    } else {
                        lane_length - current_car_pos + next_car_pos
                    };

                    // Calculate how far the current car should move (half the distance)
                    let move_distance = distance / 2;

                    // Move the current car halfway towards the next car
                    let new_pos = (current_car_pos + move_distance) % lane_length;
                    if new_pos != current_car_pos {
                        lane[current_car_pos] = 0; // Empty the current position
                        lane[new_pos] = 1; // Move the car to the new position
                    }
                }
            }
        }
    }
}

impl fmt::Display for Highway {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        for lane in &self.hwy {
            for &position in lane {
                if position == 1 {
                    write!(f, "x")?;
                } else {
                    write!(f, ".")?;
                }
            }
            writeln!(f)?;
        }
        Ok(())
    }
}