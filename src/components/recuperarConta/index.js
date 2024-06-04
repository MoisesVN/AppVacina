import { View, Text, TouchableOpacity, Image, TextInput } from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "./style";

export default function Info() {
    const navigation = useNavigation();
    return (
        <View style={styles.Tela1}>
            <View style={styles.Tela}>

                <View style={styles.Tela}><Text style={styles.Text}> Esqueci minha senha</Text>
                    <TextInput
                        style={styles.textinput}
                        placeholder="Email" />

                        
                    <TouchableOpacity onPress={() => navigation.navigate("RedefiniSenha")} style={styles.botao2}>
                        <Text style={styles.Text2}>Confirmar</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>
    )
}
