CREATE TABLE IF NOT EXISTS products(
	id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
	title VARCHAR(200) NOT NULL,
	brand VARCHAR(200),
	description VARCHAR(500),
	image_url TEXT DEFAULT NULL,
	user_id UUID REFERENCES users(id) ON DELETE CASCADE
);